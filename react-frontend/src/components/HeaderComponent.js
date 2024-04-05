import Dropdown from 'react-bootstrap/Dropdown';
import { HiCode } from "react-icons/hi";
import { Link } from "react-router-dom";

const HeaderComponent = () => {
  return (
    <div>
      <header className="fixed-top">
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <div className="container-fluid">

            {/* Adding Title */}
            <div className="d-flex justify-content-start">

              <Link className="navbar-brand" to="/about"><HiCode className="me-2" style={{ fontSize: "40px" }} />Tech Gurus</Link>
            </div>

            {/* Adding Dropdown */}
            <div className="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
              <form className="d-flex">
                <Dropdown>
                  <Dropdown.Toggle variant="secondary" id="dropdown-basic" >
                    TechUps
                  </Dropdown.Toggle>
                  <Dropdown.Menu>
                    <Dropdown.Item as={Link} to="/coders">Coders List</Dropdown.Item>
                    <Dropdown.Item as={Link} to="/add-coder">Add Coder</Dropdown.Item>
                    <Dropdown.Divider />
                    <Dropdown.Item as={Link} to="/timer">Stop Watch</Dropdown.Item>
                  </Dropdown.Menu>
                </Dropdown>
              </form>
            </div>

          </div>
        </nav>
      </header>
    </div>
  );
};

export default HeaderComponent;
