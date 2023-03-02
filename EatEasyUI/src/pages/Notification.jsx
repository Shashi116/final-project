import { useState, useEffect } from "react";
import Helmet from "../components/Helmet/Helmet";
import CommonSection from "../components/UI/common-section/CommonSection";
import { EasyEatServices } from "../components/EasyEatServices";
import { Container, Row, Col } from "reactstrap";
import { NotificationCards } from "../components/NotificationCards";
import Alert from "../components/Alert";

export function Notification() {
  const [warning, setWarning] = useState(false);
  const [warningMessage, setWarningMessage] = useState();
  const [isLoggedIn, setLoggedIn] = useState(false);
  const [orders, setOrders] = useState([]);
  const ORDER_END_POINT = "http://localhost:8080/eateasy/orders";
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

    getOrder();
  }, []);
  function getOrder() {
    const requestOptions = {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      },
    };

    fetch(
      ORDER_END_POINT + "?userEmail=" + sessionStorage.getItem("userEmail"),
      requestOptions
    )
      .then((response) => {
        if (response.status === 200) {
          console.log("Done!");
          response.json().then((result) => {
            setOrders(result);
          });
          setWarning(false);
          sessionStorage.setItem("isActive", "true");
        } else {
          response.json().then((error) => {
            setWarning(true);
            setWarningMessage(error.error);
          });
        }
      })
      .catch((error) => {
        console.log(error);
        setWarning(true);
        setWarningMessage(
          "Something went wrong please contact your primary admin"
        );
      });

    // setLoader(false);
  }

  return (
    <Helmet title="Notifications">
      <CommonSection title="Ding Dong !" />

      {isLoggedIn ? (
        <section>
          {warning && (
            <div style={{ padding: "20px" }}>
              <Alert variant="danger" message={warningMessage} />
            </div>
          )}

          <Container>
            <Row>
              {orders.map((item) => (
                <Col lg="3" md="4" sm="6" xs="6" key={item.id} className="mt-5">
                  <NotificationCards item={item} />
                </Col>
              ))}
            </Row>
          </Container>
        </section>
      ) : (
        <EasyEatServices />
      )}
    </Helmet>
  );
}
