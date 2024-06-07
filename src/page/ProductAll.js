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
  const error = useSelector((state) => state.product.error);
  const searchKeyword = useSelector((state) => state.product.searchKeyword);
  const name = query.get("name");//검색 키워드
  const page = query.get("page");//페이지

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
        {productList?.map((product, index) =>
          <Col key={product._id} className="card" md={3} sm={12}>
            <ProductCard product={product} />
          </Col>
        )}
      </Row>
    </Container>
  );
};

export default ProductAll;
