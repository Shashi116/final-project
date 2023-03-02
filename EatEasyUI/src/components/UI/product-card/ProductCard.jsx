import React from "react";

import "../../../styles/product-card.css";

import { Link } from "react-router-dom";

import { useDispatch } from "react-redux";
import { cartActions } from "../../../store/shopping-cart/cartSlice";
import defaultImg from "../../../assets/images/default.png";

const ProductCard = (props) => {
  let { id, title, image01, price, providerName, providerEmail } = props.item;
  image01 = image01 !== undefined && image01 !== null ? image01 : defaultImg;
  const dispatch = useDispatch();

  const addToCart = () => {
    dispatch(
      cartActions.addItem({
        id,
        title,
        image01,
        price,
        providerName,
        providerEmail,
      })
    );
  };

  return (
    <div className="product__item">
      <div className="product__img">
        <img src={image01} alt="product-img" className="w-50" />
      </div>

      <div className="product__content">
        <h5>
          <Link to={`/foods/${id}`}>{title}</Link>
        </h5>
        <p>Provider: {providerName}</p>
        <div className=" d-flex align-items-center justify-content-between ">
          <span className="product__price">₹{price} </span>&nbsp;
          <button className="addTOCart__btn" onClick={addToCart}>
            Add to Cart
          </button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
