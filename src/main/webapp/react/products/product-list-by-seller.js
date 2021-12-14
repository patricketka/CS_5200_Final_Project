import productService, {findProductsBySeller} from "./product-service"
const { useState, useEffect } = React;
const {Link,useParams, useHistory} = window.ReactRouterDOM;

const ProductListBySeller = () => {
    const {id} = useParams()
    const history = useHistory()
    const [products, setProducts] = useState([])
    useEffect(() => {
        findProductsBySeller(id)
    }, [])
    const findProductsBySeller = (id) =>
            productService.findProductsBySeller(id)
                .then(products => setProducts(products))
    return(
        <div>
            <h2>Product List by Seller</h2>
            <button className="btn btn-primary" onClick={() => history.push("/products/new")}>
                Add Product
            </button>
            <ul className="list-group">
                {
                    products.map(product =>
                        <li className="list-group-item"
                            key={product.id}>
                            <Link to={`/products/${product.id}`}>
                                {product.name},
                                {product.category},
                                {product.price},
                                {product.inventory},
                                {product.weight},
                                {product.ageGroup},
                                {product.discount}
                            </Link>
                            <br/>
                            <Link to={`/sellers/${product.seller.id}`}>
                                Link to Seller
                            </Link>

                        </li>)
                }
            </ul>
        </div>
    )
}
export default ProductListBySeller;