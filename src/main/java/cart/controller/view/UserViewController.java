package cart.controller.view;

import java.util.List;
import java.util.stream.Collectors;

import cart.controller.dto.UserResponse;
import cart.domain.user.User;
import cart.service.UserSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    private final UserSearchService userSearchService;

    public UserViewController(final UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @GetMapping("/settings")
    public String getSettingsPage(final Model model) {
        final List<User> users = userSearchService.findAll();
        final List<UserResponse> userResponses = users.stream()
                .map(UserResponse::from)
                .collect(Collectors.toList());
        model.addAttribute("members", userResponses);
        return "settings";
    }
}
