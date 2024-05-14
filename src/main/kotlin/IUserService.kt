import java.util.*

interface IUserService {
    fun create(user: Product): Product?
    fun getById(id: Int): Product?
    fun update(user: Product): Product?
    fun delete(id: Int): Boolean
    fun getAll(): List<Product>?
}