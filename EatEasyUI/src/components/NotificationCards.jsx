import React from "react";

import "../styles/product-card.css";

import { Link } from "react-router-dom";

import defaultImg from "../assets/images/default.png";
import { Container, Row, Col } from "reactstrap";

export const NotificationCards = (props) => {
  //   let { id, title, image01, price, providerName, providerEmail } = props.item;
  //   props.item[("abc", "abc", "abc", "abc", "abc")];
  let { productName, providerName, subscription, quantity, price, status } =
    props.item;
  let image01 = defaultImg;
  let totalPrice =
    Number(price) *
    Number(quantity) *
    Number(getSubscriptionDays(subscription));

  function getSubscriptionDays(subscription) {
    if (subscription === "Weekly") return 7;
    else if (subscription === "Monthly") return 25;
    else return 300;
  }

  return (
    <div className="product__item">
      <div className="product__img">
        <img src={image01} alt="product-img" className="w-50" />
      </div>

      <div className="product__content" style={{ padding: "0px" }}>
        <h5>{productName}</h5>

        <p>
          <b>Provider :</b> {providerName}
        </p>
        <p>
          <b>Subscription :</b> {subscription}
        </p>
        <p>
          <b>Quantity :</b> {quantity}
        </p>
        <p>
          <b>Price :</b> {price}
        </p>

        <div className=" d-flex align-items-center justify-content-between ">
          <span className="product__price">₹{totalPrice} </span>
          &nbsp;&nbsp;&nbsp;
          {/* <p>
            <b>Status :</b> {providerName}
          </p> */}
          <div className="hero__btns d-flex align-items-center gap-5 mt-4">
            <button
              className="order__btn d-flex align-items-center justify-content-between"
              disabled={true}
            >
              {status} <i class="ri-arrow-right-s-line"></i>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
