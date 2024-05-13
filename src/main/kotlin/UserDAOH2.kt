import java.sql.SQLException
import javax.sql.DataSource


class UserDAOH2(
    private val dataSource: DataSource,
    private val console: IOutPutInfo
) : IUserDAO {

    override fun create(user: Product): Product? {
        val sql = "INSERT INTO products (id, name, price, description, brand, category ) VALUES (?, ?, ?, ?, ? , ?)"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, user.id.toString())
                    stmt.setString(2, user.name)
                    stmt.setFloat(3, user.price)
                    stmt.setString(4, user.description)
                    stmt.setString(5, user.brand)
                    stmt.setString(6, user.category)

                    val rs = stmt.executeUpdate()
                    if (rs == 1) {
                        user
                    } else {
                        console.showMessage("*Error* insert query failed! ($rs records insert)")
                        null
                    }

                }
            }
        } catch (e: SQLException) {
            console.showMessage("*Error* insert query failed! ($e).")
            null
        }
    }

    override fun getById(id: Int): Product? {
        val sql = "SELECT * FROM products WHERE id = ?"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, id.toString())
                    val rs = stmt.executeQuery()
                    if (rs.next()) {
                        Product(
                            id = rs.getInt("id"),
                            name = rs.getString("name"),
                            price = rs.getFloat("price"),
                            brand = rs.getString("brand"),
                            category = rs.getString("category"),
                            description = rs.getString("description")
                        )
                    } else {
                        null
                    }
                }
            }
        } catch (e: SQLException) {
            console.showMessage("*Error* insert query failed! ($e).")
            null
        }
    }

    override fun getAll(): List<Product>? {
        val sql = "SELECT * FROM products"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    val rs = stmt.executeQuery()
                    val users = mutableListOf<Product>()
                    while (rs.next()) {
                        users.add(
                            Product(
                                id = rs.getInt("id"),
                                name = rs.getString("name"),
                                price = rs.getFloat("price"),
                                brand = rs.getString("brand"),
                                category = rs.getString("category"),
                                description = rs.getString("description")
                            )
                        )
                    }
                    users
                }
            }
        } catch (e: SQLException) {
            console.showMessage("*Error* insert query failed! ($e).")
            null
        }
    }

    override fun update(user: Product): Product? {
        val sql = "UPDATE products SET name = ?, price = ?, description = ?, brand = ?, category = ? WHERE id = ?"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(6, user.id.toString())
                    stmt.setString(1, user.name)
                    stmt.setFloat(2, user.price)
                    stmt.setString(3, user.description)
                    stmt.setString(4, user.brand)
                    stmt.setString(5, user.category)
                    val rs = stmt.executeUpdate()
                    if (rs == 1) {
                        user
                    } else {
                        console.showMessage("*Error* insert query failed! ($rs records insert)")
                        null
                    }
                }
            }
        } catch (e: SQLException) {
            console.showMessage("*Error* insert query failed! ($e).")
            null
        }
    }

    override fun delete(id: Int): Boolean {
        val sql = "DELETE FROM products WHERE id = ?"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, id.toString())
                    (stmt.executeUpdate() == 1)
                }
            }
        } catch (e: SQLException) {
            console.showMessage("*Error* insert query failed! ($e).")
            false
        }
    }
}







