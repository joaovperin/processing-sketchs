package br.com.jpe.prcskt.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@RequiredArgsConstructor
public class Line {
    private final Point p0;
    private final Point p1;

    public Line offsetX(int offset) {
        return new Line(this.p0.offsetX(offset), this.p0.offsetX(offset));
    }

    public Line offsetY(int offset) {
        return new Line(this.p0.offsetY(offset), this.p0.offsetY(offset));
    }
}
