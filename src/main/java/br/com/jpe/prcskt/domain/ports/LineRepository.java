package br.com.jpe.prcskt.domain.ports;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.jpe.prcskt.domain.Line;
import br.com.jpe.prcskt.domain.Point;

public class LineRepository {

    static final LineRepository _instance = new LineRepository();

    private final List<Line> _lines;

    private LineRepository() {
        this._lines = new ArrayList<>();
        this._lines.add(new Line(new Point(10, 10), new Point(100, 100)));
    }

    public static List<Line> get_lines() {
        return _instance._lines.stream().collect(Collectors.toList());
    }

}
