package com.lesson1.workers;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Workers {
    private ArrayList<Worker> workers = new ArrayList<Worker>();

    public ArrayList<Worker> getWorkers() {
        return this.workers;
    }

    public void addWorker(Worker worker) {
        if (worker instanceof Worker) {
            this.workers.add(worker);
        } else {
            System.err.print("Provided element is not a worker!");
        }
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (Worker worker : workers) {
            LocalDateTime sessionDate = worker.getSessionDate();

            if (worker.getTimeDuration() > 1.4 && sessionDate.getHour() >= 18 && sessionDate.getMinute() > 0) {
                String date = String.format("%d/%s/%d %d:%d", sessionDate.getDayOfMonth(), sessionDate.getMonthValue(), sessionDate.getYear(), sessionDate.getHour(), sessionDate.getMinute());
                answer.append(String.format("\n\n[RESULT]\nName: %s\nSession Date: %s\nDuration: %.1f\nGenres (-s): %s\nBudget: %.1f $\n", worker.getTitle(), date, worker.getTimeDuration(), worker.getGenre(), worker.getBudget()));
            }
        }
        return answer.toString();
    }
}
