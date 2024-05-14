
class ProductDAO {
    private val dataSource = DataSource.getDS(DataSource.DataSourceType.HIKARI)
    private val console: IOutPutInfo = Console()

    fun createProduct(product: Product) {
        UserDAOH2(dataSource, console).create(product)
    }

    fun updateProduct(product: Product) {
        UserDAOH2(dataSource, console).update(product)
    }

    fun deleteProduct(product: Product) {
        UserDAOH2(dataSource, console).delete(product.id)
    }
}