import React, { useState } from "react";
import Helmet from "../components/Helmet/Helmet";
import CommonSection from "../components/UI/common-section/CommonSection";

import { Container, Row, Col } from "reactstrap";

// import products from "../assets/fake-data/products";
import ProductCard from "../components/UI/product-card/ProductCard";
import ReactPaginate from "react-paginate";

import "../styles/all-foods.css";
import "../styles/pagination.css";
import { featureData } from "../constants/FeaturedData";
import { EasyEatServices } from "../components/EasyEatServices";
import { useEffect } from "react";

const AllFoods = () => {
  const [searchTerm, setSearchTerm] = useState("");

  const [pageNumber, setPageNumber] = useState(0);
  const [products, setProducts] = useState([]);

  // console.log(sessionStorage.getItem("Products"));

  const searchedProduct = products.filter((item) => {
    if (searchTerm.value === "") {
      return item;
    }
    if (item.title.toLowerCase().includes(searchTerm.toLowerCase())) {
      return item;
    } else {
      return console.log("not found");
    }
  });

  const productPerPage = 12;
  const visitedPage = pageNumber * productPerPage;
  const displayPage = searchedProduct.slice(
    visitedPage,
    visitedPage + productPerPage
  );

  const pageCount = Math.ceil(searchedProduct.length / productPerPage);

  const changePage = ({ selected }) => {
    setPageNumber(selected);
  };
  const [isLoggedIn, setLoggedIn] = useState(false);

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

    if (sessionStorage.getItem("Products") !== undefined) {
      setProducts(JSON.parse(sessionStorage.getItem("Products")));
    }
  }, []);

  return (
    <Helmet title="All-Foods">
      <CommonSection title="Meet our parterns !" />

      {isLoggedIn ? (
        <section>
          <Container>
            <Row>
              <Col lg="6" md="6" sm="6" xs="12">
                <div className="search__widget d-flex align-items-center justify-content-between ">
                  <input
                    type="text"
                    placeholder="I'm looking for...."
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                  />
                  <span>
                    <i class="ri-search-line"></i>
                  </span>
                </div>
              </Col>
              <Col lg="6" md="6" sm="6" xs="12" className="mb-5">
                <div className="sorting__widget text-end">
                  <select className="w-50">
                    <option>Default</option>
                    {/* <option value="ascending">Alphabetically, A-Z</option>
                  <option value="descending">Alphabetically, Z-A</option>
                  <option value="high-price">High Price</option>
                  <option value="low-price">Low Price</option> */}
                  </select>
                </div>
              </Col>

              {displayPage.map((item) => (
                <Col lg="3" md="4" sm="6" xs="6" key={item.id} className="mb-4">
                  <ProductCard item={item} />
                </Col>
              ))}

              <div>
                <ReactPaginate
                  pageCount={pageCount}
                  onPageChange={changePage}
                  previousLabel={"Prev"}
                  nextLabel={"Next"}
                  containerClassName=" paginationBttns "
                />
              </div>
            </Row>
          </Container>
        </section>
      ) : (
        <EasyEatServices />
      )}
    </Helmet>
  );
};

export default AllFoods;
