package com.backend.bakckend.leet;

import java.util.PriorityQueue;

public class SeatManager {

    private PriorityQueue<Integer> availableSeats;

    public SeatManager(int n) {
        // Initialize a priority queue with all seats from 1 to n, since all are initially available.
        availableSeats = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            availableSeats.add(i);
        }
    }

    public int reserve() {
        // Poll the smallest element from the priority queue, which is the smallest-numbered unreserved seat.
        return availableSeats.poll();
    }

    public void unreserve(int seatNumber) {
        // Add the unreserved seat back to the priority queue.
        availableSeats.add(seatNumber);
    }
}
