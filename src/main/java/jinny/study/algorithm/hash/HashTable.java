package jinny.study.algorithm.hash;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Node>[] data;

    // 고정된 사이즈의 hashTable 생성
    public HashTable(int hashSize) {
        this.data = new LinkedList[hashSize];
    }

    // hash함수 : key -> hashCode
    private int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    // hashCode -> index로 변환
    private int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }

    private Node searchKey(LinkedList<Node> searchNodes, String key) {
        for (Node node : searchNodes) {
            if (node.getKey().equals(key)) {
                return node;
            }
        }
        return null;
    }

    // HashTable 데이터 저장
    public void putHashTable(String key, String value) {
        // HashTable에 넣을 데이터 생성
        Node newData = new Node(key, value);

        // HashTable의 인덱스를 찾아서 등록
        int index = convertToIndex(getHashCode(key));
        if (this.data[index] == null) {
            LinkedList<Node> nodes = new LinkedList<>();
            nodes.add(newData);
            this.data[index] = nodes;
        } else {
            LinkedList<Node> datum = this.data[index];
            Node searchKey = searchKey(datum, key);
            if (searchKey != null) {
                searchKey.setValue(value);
            } else {
                datum.addLast(newData);
            }
        }
    }

    public String get(String key) {
        int index = convertToIndex(getHashCode(key));
        LinkedList<Node> datum = this.data[index];
        Node node = searchKey(datum, key);
        return node == null ? null : node.getValue();
    }


}
