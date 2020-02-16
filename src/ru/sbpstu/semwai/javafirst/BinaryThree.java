package ru.sbpstu.semwai.javafirst;

public class BinaryThree {
    private int value;
    private BinaryThree left;
    private BinaryThree right;

    public BinaryThree(int value) {
        this.value = value;

    }

    /**
     * Добавляет элемент в дерево
     *
     * @param value
     */
    public void append(int value) {
        //если новое число больше, чем текущее, то оно пойдет по пути правой ветки
        if (value > this.value) {
            //если правая ветка еще не создана, то мы дошли до листочка и можем вставить значение
            if (right == null) {
                right = new BinaryThree(value);
                //иначе, у нашего элемента уже есть правая ветка. Нужно попытатся повторить тоже самое для детей правой ветки.
            } else {
                right.append(value);
            }
        }
        if (value < this.value) {
            if (left == null) {
                left = new BinaryThree(value);
            } else {
                left.append(value);
            }
        }
    }

    /**
     * Определяет наличие значения value в дереве
     *
     * @return boolean
     */
    public boolean find(int value) {
        if (value == this.value)
            return true;
        if (value > this.value && this.right != null)
            return right.find(value);
        if (value < this.value && this.left != null)
            return left.find(value);
        return false;
    }

    /**
     * Удаляет элемент и возвращает новое дерево
     *
     * @return BinaryThree
     */
    public BinaryThree remove(int value) {
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
            right = right.remove(this.value);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o && o instanceof BinaryThree)
            return true;
        if (o instanceof BinaryThree) {
            BinaryThree three = (BinaryThree) o;
            if (three.value != this.value) {
                return false;
            }
            boolean out = true;
            if (this.left == null) {
                out &= three.left == null;
            } else
                out &= left.equals(three.left);
            if (this.right == null) {
                out &= three.right == null;
            } else
                out &= right.equals(three.right);
            return out;
        }
        return false;
    }

    @Override
    public String toString() {
        String left = (this.left == null) ? "" : ",\"left\":{" + this.left.toString() + "}";
        String right = (this.right == null) ? "" : ",\"right\":{" + this.right.toString() + "}";
        return "\"value\":" + this.value + left + right;
    }

    /***
     * Возвращает строку, представляющую класс в виде json объекта.
     * @return json as string
     */
    public String toJSON() {
        return "{" + toString() + "}";
    }

    /***
     *
     * @return [parent, left, right]
     */
    public BinaryThree[] friends(int value) throws Exception {
        if (value == this.value)
            return new BinaryThree[]{null, left, right};
        if (value > this.value && this.right != null)
            return right.friends(value, this);
        if (value < this.value && this.left != null)
            return left.friends(value, this);
        throw new Exception("Node hasn't exist");
    }

    private BinaryThree[] friends(int value, BinaryThree parent) throws Exception {
        if (value == this.value)
            return new BinaryThree[]{parent, left, right};
        if (value > this.value && this.right != null)
            return right.friends(value, this);
        if (value < this.value && this.left != null)
            return left.friends(value, this);
        throw new Exception("Node hasn't exist");
    }

    public int getValue() {
        return value;
    }
}