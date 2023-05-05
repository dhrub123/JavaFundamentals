package five.lambda.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateDemo {

	static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate) {
		return predicate.test(person);
	}

	static boolean isPersonEligibleForVotingUsingBP(Person person, Integer minimumAge,
			BiPredicate<Person, Integer> biPredicate) {
		return biPredicate.test(person, minimumAge);
	}

	static boolean isPersonEligibleForRetirement(Person person, Predicate<Person> predicate) {
		return predicate.test(person);
	}

	static boolean isNumberLessThanTen(Integer i, Predicate<Integer> predicate) {
		return predicate.negate().test(i);
	}

	public static void main(String[] args) {

		// example of predicate.test() -> tests for a condition
		Person dhruba = new Person("Dhruba", 37);
		Predicate<Person> predicate = p -> p.age > 18;
		boolean eligible = isPersonEligibleForVoting(dhruba, predicate);
		System.out.println("Dhruba is eligible for voting : " + eligible);

		System.out.println("Dhruba is eligible for voting : " + predicate.test(dhruba));

		// example of and --> tests for multiple conditions
		dhruba = new Person("Dhruba", 62, 35);
		Predicate<Person> ageGreaterThanSixty = p -> p.age > 60;
		Predicate<Person> serviceMoreThanThirty = p -> p.yearsOfService > 30;
		Predicate<Person> combinedPredicate = ageGreaterThanSixty.and(serviceMoreThanThirty);
		System.out.println("Dhruba eligible for retirement : " + combinedPredicate.test(dhruba));

		// example of or --> tests for either of multiple conditions
		dhruba = new Person("Dhruba", 62, 28);
		ageGreaterThanSixty = p -> p.age > 60;
		serviceMoreThanThirty = p -> p.yearsOfService > 30;
		combinedPredicate = ageGreaterThanSixty.or(serviceMoreThanThirty);
		System.out.println("Dhruba eligible for retirement : " + combinedPredicate.test(dhruba));

		// negate --> logical negation of predicate
		Predicate<Integer> numberGreaterThanTen = i -> i > 10;
		System.out.println("14 is less than 10 : " + isNumberLessThanTen(14, numberGreaterThanTen));

		/*
		 * isEqual -> predicate to test if 2 arguments are equal according to
		 * Object.equals
		 */
		Predicate<String> equalityPredicate = Predicate.isEqual("Hello");
		System.out.println(equalityPredicate.test("Welcome"));

		/*
		 * using biPredicates p -> p.age > 18, here instead of hardcoding 18, we can use
		 * bipredicate
		 */
		Person alex = new Person("Alex", 23);
		System.out.println(" Alex Eligible for voting : " + isPersonEligibleForVotingUsingBP(alex, 18, (p, minAge) -> {
			return p.age > minAge;
		}));
	}

}
