package com.m2pfintech;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
public class ProbabilityCheckerTest {

    @BeforeAll
    static void settingUpVariables(){

    }
    @Nested
    class probabilityEqualityChecker{
        @Test
        void toCheckEqualityForProbabilityOfHeadAndProbabilityOfTailForACoinToss(){
            ProbabilityChecker probabilityOfGettingHeadInACoinToss = new ProbabilityChecker(0.5);
            ProbabilityChecker probabilityOfGettingTailInACoinToss = new ProbabilityChecker(0.5);

            assertThat(probabilityOfGettingHeadInACoinToss,is(equalTo(probabilityOfGettingTailInACoinToss)));
        }
        @Test
        void toCheckEqualityForProbabilityOfHeadInCoinTossAndProbabilityOfTailForGettingASpadeFromADeckOfCards(){
            ProbabilityChecker probabilityOfGettingHeadInACoinToss = new ProbabilityChecker(0.5);
            ProbabilityChecker probabilityOfGettingSpadeInDeck = new ProbabilityChecker(0.25);

            assertThat(probabilityOfGettingHeadInACoinToss,is(not(equalTo(probabilityOfGettingSpadeInDeck))));
        }
    }
    @Nested
    class probabilityOfEventsHappeningTogether {
        @Test
        void toReturnCertainEventWhenTwoCertainEventsHappeningTogether() {

            ProbabilityChecker certainEvent = new ProbabilityChecker(1);
            ProbabilityChecker anotherCertainEvent = new ProbabilityChecker(1);

            assertThat(certainEvent.and(anotherCertainEvent),is(equalTo(certainEvent)));
        }
        @Test
        void toReturnZeroPointTwoFiveWhenTwoIndependentEventsWithPointFiveAndPointFiveShouldHappenTogether() {

            ProbabilityChecker probabilityOfGettingHeadInACoinToss = new ProbabilityChecker(0.5);
            ProbabilityChecker probabilityOfGettingABlackCardFromADeckOfCards = new ProbabilityChecker(0.5);

            ProbabilityChecker quarterProbability = new ProbabilityChecker(0.25);

            assertThat(quarterProbability, is(equalTo(probabilityOfGettingHeadInACoinToss.and(probabilityOfGettingABlackCardFromADeckOfCards))));
        }


    }
    @Nested
    class probabilityOfEventNotOccurring {
        @Test
        void toReturnOneAsProbabilityOfEventNotOccurringOfImpossibleEvents() {

            ProbabilityChecker impossibleEvent = new ProbabilityChecker(0);

            ProbabilityChecker probabilityOfEventNotOccurringOfImpossibleEvents = new ProbabilityChecker(1);

            assertThat(probabilityOfEventNotOccurringOfImpossibleEvents,is(equalTo(impossibleEvent.ProbabilityOfEventNotOccurring())));
        }
        @Test
        void toReturnZeroAsProbabilityOfEventNotOccurringOfCertainEvents() {
            ProbabilityChecker impossibleEvent = new ProbabilityChecker(1);

            ProbabilityChecker probabilityOfEventNotOccurringOfCertainEvents = new ProbabilityChecker(0);

            assertThat(probabilityOfEventNotOccurringOfCertainEvents, is(equalTo(impossibleEvent.ProbabilityOfEventNotOccurring())));
        }


        @Test
        void toReturnZeroPointSevenFiveAsProbabilityOfNotChoosingASpadeCard() {
            ProbabilityChecker probabilityForChoosingASpadeCard = new ProbabilityChecker(0.25);

            ProbabilityChecker probabilityForNotChoosingASpadeCard = new ProbabilityChecker(0.75);

            assertThat(probabilityForNotChoosingASpadeCard, is(equalTo(probabilityForChoosingASpadeCard.ProbabilityOfEventNotOccurring())));
        }
    }
}