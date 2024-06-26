import java.util.*

class UserServiceImpl(private val userDao: IUserDAO) : IUserService {
    override fun create(user: Product): Product? {
        return userDao.create(user)
    }

    override fun getById(id: Int): Product? {
        return userDao.getById(id)
    }

    override fun update(user: Product): Product? {
        return userDao.update(user)
    }

    override fun delete(id: Int): Boolean {
        return userDao.delete(id)
    }

    override fun getAll(): List<Product>? {
        return userDao.getAll()
    }
}
