import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import ApolloWrapper from "./ApolloProvider.jsx"; // Import Apollo Provider

ReactDOM.createRoot(document.getElementById("root")).render(
  <ApolloWrapper>
    <App />
  </ApolloWrapper>
);
