import java.util.*

interface IUserDAO {
    fun create(user: Product): Product?
    fun getAll(): List<Product>?
    fun getById(id: Int): Product?
    fun update(user: Product): Product?
    fun delete(id: Int): Boolean
}