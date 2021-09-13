package br.com.jpe.prcskt.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@RequiredArgsConstructor
public class Point {
    private final int x;
    private final int y;

    public Point offsetX(int offset) {
        return new Point(this.x + offset, this.y);
    }

    public Point offsetY(int offset) {
        return new Point(this.x, this.y + offset);
    }

}
