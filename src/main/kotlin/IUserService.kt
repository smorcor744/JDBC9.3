import java.util.*

interface IUserService {
    fun create(user: Product): Product?
    fun getById(id: UUID): Product?
    fun update(user: Product): Product?
    fun delete(id: UUID): Boolean
    fun getAll(): List<Product>?
}