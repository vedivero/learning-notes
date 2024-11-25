import * as types from "../constants/product.constants";
const initialState = {
  loading: false,
  error: "",
  productList: [],
  totalPageNum: 1,
  selectedProduct: null,
  hottestProductList: [],
  newArrivalProductList: [],
  discountedProducts: []
};

function productReducer(state = initialState, action) {
  const { type, payload } = action;

  switch (type) {
    case types.PRODUCT_CREATE_REQUEST:
    case types.PRODUCT_GET_REQUEST:
    case types.PRODUCT_EDIT_REQUEST:
    case types.GET_PRODUCT_DETAIL_REQUEST:
    case types.PRODUCT_GET_HOTTEST_REQUEST:
    case types.PRODUCT_GET_NEWARRIVAL_REQUEST:
    case types.PRODUCT_DISCOUNT_UPDATE_REQUEST:
    case types.PRODUCT_DISCOUNTED_REQUEST:
      return { ...state, loading: true };

    case types.PRODUCT_CREATE_SUCCESS:
      return { ...state, loading: false, error: "" };

    case types.PRODUCT_GET_SUCCESS:
      return {
        ...state,
        loading: false,
        error: "",
        productList: payload.data,
        totalPageNum: payload.totalPageNum
      };

    case types.PRODUCT_GET_HOTTEST_SUCCESS:
      return { ...state, hottestProductList: action.payload, loading: false };
    case types.PRODUCT_GET_NEWARRIVAL_SUCCESS:
      return { ...state, newArrivalProductList: action.payload, loading: false };
    case types.PRODUCT_DISCOUNT_UPDATE_SUCCESS:
      return { ...state, loading: false, error: "" };
    case types.PRODUCT_DISCOUNTED_SUCCESS:
      return { ...state, loading: false, discountedProducts: payload.data };

    case types.PRODUCT_CREATE_FAIL:
    case types.PRODUCT_GET_FAIL:
    case types.PRODUCT_EDIT_FAIL:
    case types.GET_PRODUCT_DETAIL_FAIL:
    case types.PRODUCT_GET_HOTTEST_FAIL:
    case types.PRODUCT_GET_NEWARRIVAL_FAIL:
    case types.PRODUCT_DISCOUNT_UPDATE_FAIL:
    case types.PRODUCT_DISCOUNTED_FAIL:
      return { ...state, loading: false, error: payload };

    case types.SET_SELECTED_PRODUCT:
      return { ...state, selectedProduct: payload };

    case types.GET_PRODUCT_DETAIL_SUCCESS:
      return { ...state, loading: false, selectedProduct: payload };

    default:
      return state;
  }

}

export default productReducer;
