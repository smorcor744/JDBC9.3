class Console : IOutPutInfo {

    override fun showMessage(message: String, lineBreak: Boolean) {
        if (lineBreak) {
            println(message)
        } else {
            print(message)
        }
    }


    override fun show(userList: List<Product>?, message: String) {
        if (userList != null) {
            if (userList.isNotEmpty()) {
                showMessage(message)
                userList.forEachIndexed { index, user -> showMessage("\t${index + 1}. $user",true) }
            }
        } else {
            showMessage("No users found!")
        }

    }
}