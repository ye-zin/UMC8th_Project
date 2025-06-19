package com.example.service.ReviewService;

import com.example.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ReviewQueryService {
    Page<Review> getMyReviewList(Long memberId, PageRequest pageRequest);

    Page<Review> getMyReviewList(Long memberId, Integer page);
}
