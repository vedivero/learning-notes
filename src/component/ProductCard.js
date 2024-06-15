import React from "react";
import { useNavigate } from "react-router-dom";
import { currencyFormat } from "../utils/number";
import "../style/ProductCard.css";
import { productActions } from "../action/productAction";
import { useDispatch } from "react-redux";

const ProductCard = ({ product, rank }) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  // 상품 디테일 페이지로 가기
  const showProduct = (id) => {
    dispatch(productActions.incrementViewCount(id));
    navigate(`/product/${id}`);
  };

  return (
    <div className="card" onClick={() => showProduct(product._id)}>
      {rank !== undefined && <div className="rank-badge">{`Top ${rank}`}</div>} {/* rank가 있을 때만 표시 */}
      <img src={product.image} alt={product.name} />
      <div>{product.name}</div>
      <div>\ {currencyFormat(product.price)}</div>
    </div>
  );
};

export default ProductCard;
