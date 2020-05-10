package wooteco.subway.admin.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wooteco.subway.admin.domain.Line;
import wooteco.subway.admin.service.LineService;

import java.time.LocalTime;
import java.util.List;

@Controller
public class PageController {
    public static final String REGEX = ":";

    private LineService lineService;

    public PageController(LineService lineService) {
        this.lineService = lineService;
    }

    @GetMapping(value = "/lines/form", produces = MediaType.TEXT_HTML_VALUE)
    public String lineFormPage(Model model) {
        model.addAttribute("lines", lineService.showLines());
        return "admin-line-form";
    }

    @GetMapping(value = "/lines", produces = MediaType.TEXT_HTML_VALUE)
    public String linePage(Model model) {
        model.addAttribute("lines", lineService.showLines());
        return "admin-line";
    }

    @PostMapping("/lines/form")
    public String createLineForm(@RequestParam("name") String name,
                                 @RequestParam("startTime") String startTime,
                                 @RequestParam("endTime") String endTime,
                                 @RequestParam("intervalTime") int intervalTime,
                                 Model model) {

        LocalTime start = LocalTime.of(
                Integer.parseInt(startTime.split(REGEX)[0]),
                Integer.parseInt(startTime.split(REGEX)[1]));

        LocalTime end = LocalTime.of(Integer.parseInt(endTime.split(REGEX)[0]),
                Integer.parseInt(endTime.split(REGEX)[1]));

        Line line = new Line(name, start, end, intervalTime);
        lineService.save(line);

        List<Line> lines = lineService.showLines();

        model.addAttribute("lines", lines);

        return "admin-line-form";
    }
}
