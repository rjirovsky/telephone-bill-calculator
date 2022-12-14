package com.garrettmotion.telephonebillcalculator.calculator;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author 107546
 */
public class Call {
    private Long number;
    private LocalDateTime from;
    private LocalDateTime to;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public Call(Long number, LocalDateTime from, LocalDateTime to) {
        this.number = number;
        this.from = from;
        this.to = to;
    }
    
    @Override
    public String toString() {
        return "Call{" + "number=" + number + ", from=" + from + ", to=" + to + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.number);
        hash = 29 * hash + Objects.hashCode(this.from);
        hash = 29 * hash + Objects.hashCode(this.to);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Call other = (Call) obj;
        return Objects.equals(this.number, other.number);
    }

}
