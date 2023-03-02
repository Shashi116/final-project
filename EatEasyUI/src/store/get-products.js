// import { createSlice } from "@reduxjs/toolkit";

// const initialState = {
//   products: [],
//   warning: false,
//   warningMessage: "",
// };
// const PRODUCT_END_POINT = "http://localhost:8080/eateasy/products";

// let data;

// const products = createSlice({
//   name: "productsList",
//   initialState,

//   reducers: {
//     // =========== add item ============
//     getProducts(state, action) {
//       APICall();
//       //   state.products = data;
//     },
//   },
// });

// export const GetProductDetails = () => (dispatch) => {
//   return dispatch(APICall());
// };

// export async function APICall() {
//   const requestOptions = {
//     method: "GET",
//     headers: {
//       "Content-Type": "application/json",
//       "Access-Control-Allow-Origin": "*",
//     },
//   };

//   await fetch(PRODUCT_END_POINT, requestOptions)
//     .then((response) => {
//       if (response.status === 200) {
//         console.log("Done!");
//         response.json().then((result) => {
//           //   state.warning = true;
//           //   console.log("Test");
//           //   data = result;
//         });
//         // state.warning = false;
//         console.log("Test2");
//       } else {
//         response.json().then((error) => {
//           //   state.warning = true;
//           //   state.warningMessage = error.error;
//         });
//       }
//     })
//     .catch((error) => {
//       console.log(error);
//       //   state.warning = true;
//       //   state.warningMessage =
//       //     "Something went wrong please contact your primary admin";
//     });
// }

// export const productActions = products.actions;
// export default products;
