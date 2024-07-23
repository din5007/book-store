import React, { FC } from "react";
import { Alert } from "react-bootstrap";


const ErrorMessage : FC<{ variant : string, children: any}> = ({ variant = "info", children }) => {
  return (
    <Alert variant={variant} style={{ fontSize: 20 }}>
      <strong>{children}</strong>
    </Alert>
  );
};

export default ErrorMessage;