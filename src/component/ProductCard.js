import React from "react";
import { useNavigate } from "react-router-dom";
import { currencyFormat } from "../utils/number";
import "../style/ProductCard.css";
import { productActions } from "../action/productAction";
import { useDispatch } from "react-redux";

const ProductCard = ({ product, rank, isNew }) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  // 상품 디테일 페이지로 가기
  const showProduct = (id) => {
    dispatch(productActions.incrementViewCount(id));
    navigate(`/product/${id}`);
  };

  const discountPercentage = product.originalPrice
    ? ((product.originalPrice - product.price) / product.originalPrice) * 100
    : 0;

  return (
    <div className="card" onClick={() => showProduct(product._id)}>
      {isNew ? (
        <div className="new-badge">NEW</div> // isNew가 true이면 NEW 배지 표시
      ) : rank !== undefined ? (
        <div className="rank-badge">{`Top ${rank}`}</div> // rank가 있을 때만 표시
      ) : null}
      {product.originalPrice && product.price !== product.originalPrice && (
        <div className="sale-badge">SALE</div> // SALE 배지 표시
      )}
      <img src={product.image} alt={product.name} />
      <div>{product.name}</div>
      {product.originalPrice && product.price !== product.originalPrice ? (
        <div className="price-info">
          <span className="original-price">₩ {currencyFormat(product.originalPrice)}</span>
          <span className="discount-arrow">→</span>
          <span className="discounted-price">₩ {currencyFormat(product.price)}</span>
          <span className="discount-badge">{discountPercentage.toFixed(0)}% 할인</span>
        </div>
      ) : (
        <div>₩ {currencyFormat(product.price)}</div>
      )}
    </div>
  );
};

export default ProductCard;
