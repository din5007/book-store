import { FC } from "react";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/esm/Row";

const MainScreen: FC<{ title: string; children: any }> = ({
  title,
  children,
}) => {
  return (
    <div
      style={{
        minHeight: "93vh",
        display: "flex",
        padding: "10px 0",
      }}
    >
      <Container>
        <Row>
          <div className="w-100">
            {title && (
              <>
                <h1>{title}</h1>
              </>
            )}
            {children}
          </div>
        </Row>
      </Container>
    </div>
  );
};

export default MainScreen;
