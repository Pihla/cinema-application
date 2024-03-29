package com.example.cinemaapplication.service;


import java.util.*;


public class SeatService {

    public String[][] recommendSeats(int numberOfSeats) {
        Seat[][] seats = generateSeats();

        if(numberOfSeats == 1) {
            Seat chosenSeat = Collections.max(getEmptySeats(seats));
            chosenSeat.status = Seat.Status.CHOSEN;
        }
        else {
            List<AdjacentSeatsInfo> adjacentSeats = findFreeAdjacentSeats(seats, numberOfSeats);
            if(adjacentSeats.isEmpty()) {
                List<Seat> emptySeats = getEmptySeats(seats);
                emptySeats.sort(Collections.reverseOrder());
                for (int i = 0; i < numberOfSeats; i++) {
                    emptySeats.get(i).status = Seat.Status.CHOSEN;
                }
            }
            else {
                AdjacentSeatsInfo chosenSeats = Collections.max(adjacentSeats);
                for (int i = chosenSeats.startIndex; i < chosenSeats.startIndex + numberOfSeats; i++) {
                    seats[chosenSeats.row][i].status = Seat.Status.CHOSEN;
                }
            }
        }

        return seatsToStrings(seats);
    }

    private List<Seat> getEmptySeats(Seat[][] seats) {
        List<Seat> emptySeats = new ArrayList<>();
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.status == Seat.Status.FREE)
                    emptySeats.add(seat);
            }
        }
        return emptySeats;
    }

    private boolean possibleToGetAdjacentSeats(Seat[] row, int startIndex, int numberOfSeats) {
        for (int i = startIndex; i < startIndex + numberOfSeats; i++) {
            if(row[i].status == Seat.Status.TAKEN)
                return false;
        }
        return true;
    }

    private int sumOfAdjacentSeatRatings(Seat[] row, int startIndex, int numberOfSeats) {
        int sum = 0;
        for (int i = startIndex; i < startIndex + numberOfSeats; i++) {
            sum += row[i].seatRating;
        }
        return sum;
    }

    private List<AdjacentSeatsInfo> findFreeAdjacentSeats(Seat[][] seats, int numberOfSeats) {
        List<AdjacentSeatsInfo> adjacentSeatsInfoList = new ArrayList<>();

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length - numberOfSeats + 1; j++) {
                if(possibleToGetAdjacentSeats(seats[i], j, numberOfSeats)) {
                    int sumOfRatings = sumOfAdjacentSeatRatings(seats[i], j, numberOfSeats);
                    adjacentSeatsInfoList.add(new AdjacentSeatsInfo(i, j, numberOfSeats, sumOfRatings));
                }
            }
        }

        return adjacentSeatsInfoList;
    }


    private Seat[][] generateSeats() {
        int rows = 7;
        int seatsInRow = 10;
        Seat[][] seats = new Seat[rows][seatsInRow];

        //all seats are free in the beginning
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                seats[i][j] = new Seat(i, j, Seat.Status.FREE, rows, seatsInRow);
            }
        }

        //randomly choose taken seats
        Random random = new Random();
        for (int i = 0; i < 40; i++) {//note: since the code doesn't check status, there might be less than 40 taken seats
            int takenRow = random.nextInt(rows);
            int takenSeatInRow = random.nextInt(seatsInRow);
            seats[takenRow][takenSeatInRow].status = Seat.Status.TAKEN;
        }

        return seats;
    }


    private String[][] seatsToStrings(Seat[][] seats) {
        String[][] seatsAsStrings = new String[seats.length][seats[0].length];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seatsAsStrings[i][j] = seats[i][j].status.toString();
            }
        }
        return seatsAsStrings;
    }

    private static class AdjacentSeatsInfo implements Comparable<AdjacentSeatsInfo>{
        int row;
        int startIndex;
        int numberOfSeats;
        Integer seatRatingsCombined;

        public AdjacentSeatsInfo(int row, int startIndex, int numberOfSeats, int seatRatingsCombined) {
            this.row = row;
            this.startIndex = startIndex;
            this.numberOfSeats = numberOfSeats;
            this.seatRatingsCombined = seatRatingsCombined;
        }

        @Override
        public int compareTo(AdjacentSeatsInfo o) {
            return this.seatRatingsCombined.compareTo(o.seatRatingsCombined);
        }
    }

    private static class Seat implements Comparable<Seat>{
        int row;
        int seatInRow;
        Status status;
        Integer seatRating;//higher ratings are better

        void calculateAndSetSeatRating(int totalRows, int totalSeatsInRows) {
            //ratings are negative or equal to zero. ratings that are closer to zero are better.
            int rowRating = -Math.abs(totalRows - 2 * row);
            int seatInRowRating = -Math.abs(totalSeatsInRows - 2 * seatInRow);
            seatRating = rowRating + seatInRowRating;
        }

        Seat(int row, int seatInRow, Status status, int totalRows, int totalSeatsInRow) {
            this.row = row;
            this.seatInRow = seatInRow;
            this.status = status;
            calculateAndSetSeatRating(totalRows, totalSeatsInRow);
        }

        @Override
        public int compareTo(Seat o) {
            return this.seatRating.compareTo(o.seatRating);
        }

        enum Status {
            FREE, TAKEN, CHOSEN
        }
    }
}
