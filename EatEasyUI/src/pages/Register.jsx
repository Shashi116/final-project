import React, { useRef } from "react";
import Helmet from "../components/Helmet/Helmet";
import CommonSection from "../components/UI/common-section/CommonSection";
import { Container, Row, Col } from "reactstrap";
import { Link } from "react-router-dom";

import { getRole } from "../components/utility/EasyEatHelper";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { EasyEatServices } from "../components/EasyEatServices";
import { Base64 } from "../components/utility/EasyEatHelper";
import Spinner from "react-bootstrap/Spinner";
import Alert from "../components/Alert";

const Register = () => {
  const navigate = useNavigate();
  const [isLoggedIn, setLoggedIn] = useState(false);
  const [loader, setLoader] = useState(false);
  const [warningMessage, setWarningMessage] = useState();
  const [warning, setWarning] = useState(false);
  // const signupNameRef = useRef();
  // const signupPasswordRef = useRef();
  // const signupEmailRef = useRef();

  useEffect(() => {
    // const filteredPizza = products.filter((item) => item.category === "Pizza");
    // const slicePizza = filteredPizza.slice(0, 4);
    // setHotPizza(slicePizza);

    if (
      sessionStorage.getItem("isActive") !== null &&
      sessionStorage.getItem("isActive") === "true"
    ) {
      setLoggedIn(true);
    }
  }, []);

  const REGISTER_END_POINT = "http://localhost:8080/eateasy/add";

  const submitHandler = (e) => {
    e.preventDefault();

    setLoader(true);

    let name = e.target[0].value;
    let email = e.target[1].value;
    let password = e.target[2].value;
    let phoneNumber = e.target[3].value;
    let role = getRole(
      e.target[4].checked,
      e.target[5].checked,
      e.target[6].checked
    );

    password = btoa(password);

    const userInfo = { name, email, password, phoneNumber, role };

    const requestOptions = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      },
      body: JSON.stringify(userInfo),
    };
    fetch(REGISTER_END_POINT, requestOptions)
      .then((response) => {
        if (response.status === 200) {
          console.log("Done!");

          sessionStorage.setItem("isActive", "true");
          sessionStorage.setItem("userEmail", email);
          navigate("/home");
        } else {
          response.json().then((error) => {
            setWarning(true);
            setWarningMessage(error.error);
          });
        }
      })

      .catch((error) => {
        console.error("There was an error!", error);
      });
    setLoader(false);
  };

  return (
    <>
      {!isLoggedIn ? (
        <div disabled={loader}>
          <Helmet title="Signup">
            <CommonSection title="Who are you ?" />
            {warning && (
              <div style={{ padding: "20px" }}>
                <Alert variant="danger" message={warningMessage} />
              </div>
            )}
            {loader && (
              <div
                style={{
                  alignItems: "center",
                  justifyContent: "center",
                  display: "flex",
                }}
              >
                <Spinner animation="grow" variant="primary" />
                <Spinner animation="grow" variant="primary" />
                <Spinner animation="grow" variant="primary" />
                <Spinner animation="grow" variant="primary" />
                <Spinner animation="grow" variant="primary" />
                <Spinner animation="grow" variant="primary" />
              </div>
            )}
            <section>
              <Container>
                <Row>
                  <Col lg="6" md="6" sm="12" className="m-auto text-center">
                    <form className="form mb-5" onSubmit={submitHandler}>
                      <div className="form__group">
                        <input
                          type="text"
                          placeholder="How should I call you"
                          required
                          // ref={signupNameRef}
                        />
                      </div>
                      <div className="form__group">
                        <input
                          type="email"
                          placeholder="Your Email Address"
                          required
                          // ref={signupEmailRef}
                        />
                      </div>
                      <div className="form__group">
                        <input
                          type="password"
                          placeholder="Have strong Password"
                          required
                          // ref={signupPasswordRef}
                        />
                      </div>
                      <div className="form__group">
                        <input
                          placeholder="Your phone number"
                          required
                          // ref={signupPasswordRef}
                        />
                      </div>

                      <div>
                        <input type="radio" value="User" name="gender" /> User
                        &nbsp;&nbsp;
                        <input
                          type="radio"
                          value="Provider"
                          name="gender"
                        />{" "}
                        Provider &nbsp;&nbsp;
                        <input type="radio" value="Admin" name="gender" /> Admin
                        &nbsp;&nbsp;
                        <br></br>
                        <br></br>
                      </div>
                      <button type="submit" className="addTOCart__btn">
                        Sign Up
                      </button>
                    </form>
                    <Link to="/auth">Already have an account? Login</Link>
                  </Col>
                </Row>
              </Container>
            </section>
          </Helmet>
        </div>
      ) : (
        <Helmet title="Signout">
          <CommonSection title="Would like to sign out ?" />
          <EasyEatServices typeOfButton="logout" />
        </Helmet>
      )}
    </>
  );
};

export default Register;
