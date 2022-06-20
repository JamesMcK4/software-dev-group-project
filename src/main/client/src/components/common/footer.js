import {Navbar, Container} from 'react-bootstrap'

const Footer = () => {
    return (
        <footer>
            <Navbar expand="lg" variant="dark" bg="success" fixed="bottom">
                <Container>
                    <Navbar.Text>
                        &copy;2022 Summer CSCI 3130 Group 24
                    </Navbar.Text>
                </Container>
            </Navbar>
        </footer>)       
}
export default Footer;