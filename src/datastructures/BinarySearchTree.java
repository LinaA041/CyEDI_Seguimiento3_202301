package datastructures;

/*Codigo base utilizado para la estructura del bst: https://github.com/Domiciano/APO2-231.git*/

public class BinarySearchTree <K extends Comparable<K>,T> implements IBinarySearchTree<K,T> {

    private Node <K,T> root;

    public T getRoot(){

        if (root == null) return null;

        return root.getValue();
    }


    public void insert(K key, T value){

        if(root==null){

            root = new Node<>(key,value);

            System.out.println(root.getKey());

        }else{insert(root, new Node<>(key, value));}

    }

    private void insert(Node <K,T> current, Node <K,T> node) {

        if (node.getKey().compareTo(current.getKey()) < 0) {

            if (current.getLeft() == null) {

                current.setLeft(node);

            } else {

                insert(current.getLeft(), node);
            }

        } else if (node.getKey().compareTo(current.getKey()) > 0) {

            if (current.getRight() == null) {

                current.setRight(node);

            } else {

                insert(current.getRight(), node);

            }

        }
    }
    public String inOrder() {

        StringBuilder sb = new StringBuilder(); //Concatena espacios y las "claves"

        inOrder(root, sb);

        return sb.toString().trim();
    }

    private void inOrder(Node<K, T> current, StringBuilder sb) {

        if (current == null) {

            return;

        }
        inOrder(current.getLeft(), sb);

        sb.append(current.getKey());

        sb.append(" ");

        inOrder(current.getRight(), sb);

    }

    public T search(K goal){

        return search(root, goal);

    }

    private T search(Node <K,T>current, K goal){

        if(current==null){

            System.out.println("Not found");

            return null;
        }
        if(current.getKey().equals(goal)){return current.getValue();}

        if(goal.compareTo(current.getKey()) < 0){

            return search(current.getLeft(), goal);

        }else{

            return search(current.getRight(), goal);

        }
    }
    public T delete(K goal) {

        return delete(null, root, goal);

    }

    private T delete(Node<K, T> parent, Node<K, T> current, K goal) {

        if(current == null){

            return null;

        }

        //Encontramos al nodo

        if(goal.equals(current.getKey())){

            if(current.getRight() == null && current.getLeft() == null){

                if (parent == null) root = null;

                else {

                    if (parent.getLeft() == current) parent.setLeft(null);

                    else parent.setRight(null);

                }

                return current.getValue();
            }

            //Eliminar un nodo que tiene hijo derecho

            else if(current.getRight() != null && current.getLeft() == null){

                if(parent==null)root= current.getRight();

                else {

                    if(parent.getLeft() == current) parent.setLeft(current.getRight());

                    else parent.setRight(current.getRight());

                }
                return current.getValue();
            }
            //Eliminar un nodo que tiene hijo izquierdo

            else if(current.getRight() == null && current.getLeft() != null){

                if(parent==null)root= current.getLeft();

                else{

                if(parent.getLeft() == current) parent.setLeft(current.getLeft());

                else parent.setRight(current.getLeft());

                }

                return current.getValue();
            }
            //Eliminar un nodo que tiene dos hijos
            else if(current.getRight() != null && current.getLeft()!=null){

                Node<K, T> successor = getSuccessor(current); //sin esto

                T value = current.getValue(); // Y esto, dos de los test fallan

                current.setKey(successor.getKey());

                current.setValue(successor.getValue());

                delete(current, current.getRight(), successor.getKey());

                return value;

            }
        }
        else if(goal.compareTo(current.getKey()) < 0){

            delete(current, current.getLeft(), goal);

        }else if(goal.compareTo(current.getKey()) > 0){

            delete(current, current.getRight(), goal);

        }
        return null;
    }
    private Node<K, T> getSuccessor(Node<K, T> node) {

        Node<K, T> current = node.getRight();

        while (current.getLeft() != null) {

            current = current.getLeft();

        }

        return current;
    }

}
