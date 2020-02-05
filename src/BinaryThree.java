public class BinaryThree {
    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }

        void append(int value) {
            //если новое число больше, чем текущее, то оно пойдет по пути правой ветки
            if (value > this.value) {
                //если правая ветка еще не создана, то мы дошли до листочка и можем вставить значение
                if (right == null) {
                    right = new Node(value);
                    //иначе, у нашего элемента уже есть правая ветка. Нужно попытатся повторить тоже самое для детей правой ветки.
                } else {
                    right.append(value);
                }
            }
            if (value < this.value) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.append(value);
                }
            }
        }

        boolean find(int value) {
            if (value == this.value)
                return true;
            if (value > this.value && this.right != null)
                return right.find(value);
            if (value < this.value && this.left != null)
                return left.find(value);
            return false;
        }

        Node remove(int value) {
            if (value > this.value && this.right != null)
                right = right.remove(value);
            if (value < this.value && this.left != null)
                left = left.remove(value);
            if (value == this.value) {
                if (left == null && right == null)
                    return null;
                if (left == null)
                    return right;
                if (right == null)
                    return left;

                    this.value = right.value;
                    root = right;
                    right = right.remove(this.value);

            }
            return this;
        }
    }

    private Node root;


    public BinaryThree() {

    }

    BinaryThree(int value) {
        root = new Node(value);

    }

    void append(int value) {
        root.append(value);
    }

    /**
     * Определяет наличие значения value в дереве
     *
     * @return boolean
     */
    boolean find(int value) {
        return root.find(value);
    }

    /**
     *
     */
    void remove(int value) {
        root = root.remove(value);
    }
}