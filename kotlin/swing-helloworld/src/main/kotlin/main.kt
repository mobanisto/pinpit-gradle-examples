import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JFrame.EXIT_ON_CLOSE
import javax.swing.JPanel

fun main() {
    val frame = JFrame("Hello World")
    val panel = JPanel().also { frame.contentPane = it }
    val button = JButton("Hello, World!")
    panel.add(button)

    button.addActionListener {
        button.text = "Hello, Desktop!"
    }

    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.size = Dimension(800, 600)
    frame.isVisible = true
}
