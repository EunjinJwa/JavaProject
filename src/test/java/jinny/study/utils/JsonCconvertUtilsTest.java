package jinny.study.utils;

import jinny.study.domain.Member;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonCconvertUtilsTest {

	@Test
	void convertJsonArray() {
		Member member1 = new Member("1", "jinny", 23);
		Member member2 = new Member("2", "jinny2", 30);
		List<Member> members = Arrays.asList(member1, member2);

		System.out.println(JsonCconvertUtils.convertJsonArray(members));
	}

}
