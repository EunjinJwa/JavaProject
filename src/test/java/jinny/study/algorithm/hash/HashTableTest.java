package jinny.study.algorithm.hash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class HashTableTest {

    @Test
    public void hashTableTest() {
        // given
        HashTable hashTable = new HashTable(3);
        hashTable.putHashTable("kassy", "AA");
        hashTable.putHashTable("kevin", "BB");
        hashTable.putHashTable("katty", "CC");
        hashTable.putHashTable("kevin", "2BB+1");

        // when
        String value = hashTable.get("kassy");
        String value2 = hashTable.get("kevin");
        System.out.println(value2);

        Assertions.assertThat(value).isEqualTo("AA");

    }

}
