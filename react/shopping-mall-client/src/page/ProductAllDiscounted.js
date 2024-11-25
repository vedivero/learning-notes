import React, { useEffect } from "react";
import ProductCard from "../component/ProductCard";
import { Row, Col, Container } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { productActions } from "../action/productAction";
import "../style/ProductCard.css";

const ProductAllDiscounted = () => {
	const dispatch = useDispatch();
	const { discountedProducts, loading, error } = useSelector((state) => state.product);

	useEffect(() => {
		dispatch(productActions.getDiscountedProducts());
	}, [dispatch]);

	return (
		<Container>
			<Row>
				{loading ? (
					<div>Loading...</div>
				) : error ? (
					<div>{error}</div>
				) : (
					discountedProducts && discountedProducts.length > 0 ? (
						discountedProducts.map((product) => (
							<Col key={product._id} className="card" md={3} sm={12}>
								<ProductCard product={product} isSale />
							</Col>
						))
					) : (
						<div className="text-align-center empty-bag">
							<h2>등록된 상품이 없습니다.</h2>
						</div>
					)
				)}
			</Row>
		</Container>
	);
};

export default ProductAllDiscounted;
