import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Container, Row, Col, Button, Dropdown } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { productActions } from "../action/productAction";
import { ColorRing } from "react-loader-spinner";
import { cartActions } from "../action/cartAction";
import { currencyFormat } from "../utils/number";
import "../style/productDetail.style.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCartArrowDown } from "@fortawesome/free-solid-svg-icons";

const ProductDetail = () => {
  const dispatch = useDispatch();
  const selectedProduct = useSelector((state) => state.product.selectedProduct);
  const loading = useSelector((state) => state.product.loading);
  const [size, setSize] = useState("");
  const { id } = useParams();
  const navigate = useNavigate();
  const [sizeError, setSizeError] = useState(false);
  const { user } = useSelector((state) => state.user);

  // 카트에 상품 추가
  const addItemToCart = () => {
    // 사이즈 선택 체크
    if (size === "") {
      setSizeError(true);
      return;
    }
    // 로그인 여부 체크
    if (!user) {
      alert("로그인 후 카트에 추가해 주세요.");
      navigate("/login");
    }
    // 카트에 아이템 추가
    dispatch(cartActions.addToCart({ id, size }));
  };

  // 사이즈 추가
  const selectSize = (value) => {
    if (sizeError) setSizeError(false); // 에러 메시지 초기화
    setSize(value);
  };

  // 상품 디테일 정보 가져오기
  useEffect(() => {
    dispatch(productActions.getProductDetail(id));
  }, [id]);

  if (loading || !selectedProduct)
    return (
      <ColorRing
        visible={true}
        height="80"
        width="80"
        ariaLabel="blocks-loading"
        wrapperStyle={{}}
        wrapperClass="blocks-wrapper"
        colors={["#e15b64", "#f47e60", "#f8b26a", "#abbd81", "#849b87"]}
      />
    );

  const isSale = selectedProduct.originalPrice && selectedProduct.price !== selectedProduct.originalPrice;

  return (
    <Container className="product-detail-card">
      <Row>
        <Col sm={6} className="position-relative">
          <img src={selectedProduct.image} className="w-100" alt="image" />
          {isSale && <div className="sale-badge">SALE</div>}
        </Col>
        <Col className="product-info-area" sm={6}>
          <div className="product-info">{selectedProduct.name}</div>
          {isSale ? (
            <div className="product-info price-info">
              <span className="original-price">₩ {currencyFormat(selectedProduct.originalPrice)}</span>
              <span className="discount-arrow">→</span>
              <span className="discounted-price">₩ {currencyFormat(selectedProduct.price)}</span>
              <span className="discount-badge">
                {((selectedProduct.originalPrice - selectedProduct.price) / selectedProduct.originalPrice * 100).toFixed(0)}% OFF
              </span>
            </div>
          ) : (
            <div className="product-info">₩ {currencyFormat(selectedProduct.price)}</div>
          )}
          <div className="product-info">{selectedProduct.description}</div>

          <Dropdown
            className="drop-down size-drop-down"
            title={size}
            align="start"
            onSelect={(value) => selectSize(value)}
          >
            <Dropdown.Toggle
              className="size-drop-down"
              variant={sizeError ? "outline-danger" : "outline-dark"}
              id="dropdown-basic"
              align="start"
            >
              {size === "" ? "사이즈 선택" : size.toUpperCase()}
            </Dropdown.Toggle>

            <Dropdown.Menu className="size-drop-down">
              {Object.keys(selectedProduct.stock).length > 0 &&
                Object.keys(selectedProduct.stock).map((item) =>
                  selectedProduct.stock[item] > 0 ? (
                    <Dropdown.Item key={item} eventKey={item}>
                      {item.toUpperCase()}
                    </Dropdown.Item>
                  ) : (
                    <Dropdown.Item key={item} eventKey={item} disabled={true}>
                      {item.toUpperCase()}
                    </Dropdown.Item>
                  )
                )}
            </Dropdown.Menu>
          </Dropdown>
          <div className="warning-message">
            {sizeError && "사이즈를 선택해주세요."}
          </div>
          <Button variant="dark" className="add-button" onClick={addItemToCart}>
            <FontAwesomeIcon icon={faCartArrowDown} style={{ marginRight: "8px" }} />
            카트에 담기
          </Button>
        </Col>
      </Row>
    </Container>
  );
};

export default ProductDetail;
