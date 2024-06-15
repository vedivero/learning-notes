import React from "react";
import { useNavigate } from "react-router-dom";
import { currencyFormat } from "../utils/number";
import "../style/ProductCard.css";
import { productActions } from "../action/productAction";
import { useDispatch } from "react-redux";

const ProductCard = ({ product, rank, isNew, isSale }) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  // 상품 디테일 페이지로 가기
  const showProduct = (id) => {
    dispatch(productActions.incrementViewCount(id));
    navigate(`/product/${id}`);
  };

  const calculateDiscountPercentage = (originalPrice, discountedPrice) => {
    return ((originalPrice - discountedPrice) / originalPrice * 100).toFixed(0);
  };

  return (
    <div className="card" onClick={() => showProduct(product._id)}>
      {isNew && <div className="new-badge">NEW</div>}
      {rank !== undefined && <div className="rank-badge">{`Top ${rank}`}</div>}
      {isSale && <div className="sale-badge">SALE</div>}
      <img src={product.image} alt={product.name} />
      <div>{product.name}</div>
      {isSale && product.originalPrice && product.originalPrice !== product.price ? (
        <div className="price-info">
          <span className="original-price">{currencyFormat(product.originalPrice)}</span>
          <span className="discount-arrow">→</span>
          <span className="discounted-price">{currencyFormat(product.price)}</span>
          <span className="discount-badge">{calculateDiscountPercentage(product.originalPrice, product.price)}% OFF</span>
        </div>
      ) : (
        <div>\ {currencyFormat(product.price)}</div>
      )}
    </div>
  );
};

export default ProductCard;
