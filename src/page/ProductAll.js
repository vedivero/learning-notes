import React, { useEffect, useState } from "react";
import ProductCard from "../component/ProductCard";
import { Row, Col, Container } from "react-bootstrap";
import { useSearchParams, useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { productActions } from "../action/productAction";


const ProductAll = () => {
  const navigate = useNavigate();
  const { productList, totalPageNum } = useSelector((state) => state.product);
  const dispatch = useDispatch();
  const [query, setQuery] = useSearchParams();
  const name = query.get("name");//검색 키워드

  // 처음 로딩하면 상품리스트 불러오기
  useEffect(() => {
    dispatch(productActions.getProductList({ name }));
  }, [query])

  //검색 searchbox에서
  useEffect(() => {

    const searchQuery = {
      page: query.get("page") || 1,
      name: query.get("name") || "",
    };
    //검색어에 해당되는 값이 있을 경우
    const params = new URLSearchParams(searchQuery);
    //convert to String
    const navigateQuery = params.toString();
    navigate("?" + navigateQuery);

  }, [name]);

  return (
    <Container>
      <Row>
        {productList.length > 0 ? (
          productList.map((product) => (
            <Col key={product._id} className="card" md={3} sm={12}>
              <ProductCard product={product} />
            </Col>
          ))
        ) : (
          <div className="text-align-center empty-bag">
            {name === "" ? (
              <h2>등록된 상품이 없습니다.</h2>
            ) : (
              <h2>{name} 와(과) 일치한 상품이 없습니다.</h2>
            )}
          </div>
        )}
      </Row>
    </Container>
  );
};

export default ProductAll;
