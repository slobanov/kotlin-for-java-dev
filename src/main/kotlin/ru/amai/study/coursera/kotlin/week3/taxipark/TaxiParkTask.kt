package ru.amai.study.coursera.kotlin.week3.taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    allDrivers - trips.map { it.driver }.toSet()

private fun List<Trip>.filterByCount(minCount: Int) =
    flatMap { it.passengers }
        .groupBy { it }
        .filterValues { it.size >= minCount }
        .keys
        .toSet()
/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> {
    return if (minTrips == 0) allPassengers else trips.filterByCount(minTrips)
}
/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    trips.filter { it.driver == driver }.filterByCount(2)

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val (tripsWithDiscount, tripsWithoutDiscount) =
        trips.partition { (it.discount ?: 0.0) > 0 }

    fun List<Trip>.countWith(p: Passenger) = count { p in it.passengers }

    return allPassengers
        .filter { tripsWithDiscount.countWith(it) > tripsWithoutDiscount.countWith(it) }
        .toSet()
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */

fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? =
    trips.map { 10 * (it.duration / 10) }
        .groupingBy { it..(it+9) }
        .eachCount()
        .maxBy { it.value }
        ?.key

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    val driverContributions = trips
        .groupBy { it.driver }
        .map { (_, trips) -> trips.sumByDouble { it.cost } }
        .sortedDescending()

    val totalSum = trips.sumByDouble(Trip::cost)
    val topDriversCount = (0.2 * allDrivers.size).toInt()

    return totalSum > 0 &&
            driverContributions.take(topDriversCount).sum() >= 0.8*totalSum
}