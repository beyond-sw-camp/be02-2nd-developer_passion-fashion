package com.example.lonua.review.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.lonua.common.BaseRes;
import com.example.lonua.product.model.entity.Product;
import com.example.lonua.product.model.entity.ProductImage;
import com.example.lonua.product.model.response.GetListProductRes;
import com.example.lonua.review.model.entity.Review;
import com.example.lonua.review.model.request.*;
import com.example.lonua.review.model.response.GetListReviewRes;
import com.example.lonua.review.model.response.GetReadReviewRes;
import com.example.lonua.review.model.response.PostReviewRes;
import com.example.lonua.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final AmazonS3 s3;

    @Value("${cloud.aws.s3.review-bucket}")
    private String bucket;

    private final ReviewRepository reviewRepository;

    public String makeFolder(){
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String folderPath = str.replace("/", File.separator);
        return folderPath;
    }

<<<<<<< HEAD
    public String saveFile(MultipartFile file) {
        String originalName = file.getOriginalFilename();

        String folderPath = makeFolder();
        String uuid = UUID.randomUUID().toString();
        String saveFileName = folderPath + File.separator + uuid + "_" + originalName;

        try {

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            s3.putObject(bucket, saveFileName.replace(File.separator, "/"), file.getInputStream(), metadata);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 로컬 파일 시스템에서 파일 삭제
            File localFile = new File(saveFileName);
            if (localFile.exists()) {
                localFile.delete();
            }
            return s3.getUrl(bucket, saveFileName.replace(File.separator, "/")).toString();

        }
    }

    @Transactional
    public BaseRes registerReview(PostRegisterReviewReq postRegisterReviewReq, MultipartFile file) {

        String reviewPhoto = saveFile(file);

        reviewRepository.save(Review.builder()
                .product(Product.builder().productIdx(postRegisterReviewReq.getProductIdx()).build())
                .reviewContent(postRegisterReviewReq.getReviewContent())
                .reviewPhoto(reviewPhoto.replace(File.separator, "/"))
                .evaluation(postRegisterReviewReq.getEvaluation())
=======
         reviewRepository.save(Review.builder()
                .user(User.builder().userIdx(1).build())
                .product(Product.builder().productIdx(request.getProductIdx()).build())
                .reviewContent(request.getReviewContent())
                .reviewPhoto(request.getReviewPhoto())
                .evaluation(request.getEvaluation())
>>>>>>> feature/swagger
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .status(true)
                .build());


        BaseRes baseRes = BaseRes.builder()
                .code(200)
                .isSuccess(true)
                .message("리뷰를 등록했습니다.")
                .result(postRegisterReviewReq)
                .build();

        return baseRes;

    }

    public BaseRes readReview(Integer reviewIdx) {

        Optional<Review> result = reviewRepository.findByReviewIdx(reviewIdx);
        if (result.isPresent()) {
            Review review = result.get();

<<<<<<< HEAD
            GetReadReviewRes getReadReviewRes = GetReadReviewRes.builder()
                .reviewContent(review.getReviewContent())
                .reviewPhoto(review.getReviewPhoto())
                .evaluation(review.getEvaluation())
                .build();
=======
//             PostReviewReq.builder()
//                .reviewIdx(review.getReviewIdx())
//                .reviewContent(review.getReviewContent())
//                .reviewPhoto(review.getReviewPhoto())
//                .evaluation(review.getEvaluation())
//                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
//                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
//                .build();
>>>>>>> feature/swagger

            BaseRes baseRes = BaseRes.builder()
                    .code(200)
                    .isSuccess(true)
                    .message("리뷰를 가져왔습니다.")
                    .result(getReadReviewRes)
                    .build();

            return baseRes;

        } else {
            return null;
        }

    }


    public BaseRes listReview(Integer productIdx) {

        List<Review> reviewList = reviewRepository.findByProduct_ProductIdx(productIdx);
        List<GetListReviewRes> response = new ArrayList<>();

        for(Review review : reviewList) {

            GetListReviewRes getListReviewRes = GetListReviewRes.builder()
                    .productName(review.getProduct().getProductName())
                    .productImage(review.getProduct().getProductImageList().get(0).getProductImage())
                    .reviewContent(review.getReviewContent())
                    .reviewPhoto(review.getReviewPhoto())
                    .evaluation(review.getEvaluation())
                    .updatedAt(review.getUpdatedAt())
                    .build();
            response.add(getListReviewRes);
        }

        BaseRes baseRes = BaseRes.builder()
                .code(200)
                .isSuccess(true)
                .message("리뷰를 가져왔습니다.")
                .result(response)
                .build();

        return baseRes;

    }


    public BaseRes updateReview(UpdateReviewReq request) {

        Optional<Review> result = reviewRepository.findByReviewIdx(request.getReviewIdx());

        if (result.isPresent()) {
            Review review = result.get();
            review.setReviewContent(request.getReviewContent());
            review.setReviewPhoto(request.getReviewPhoto());
            review.setEvaluation(request.getEvaluation());

            reviewRepository.save(review);

            BaseRes baseRes = BaseRes.builder()
                    .code(200)
                    .isSuccess(true)
                    .message("리뷰를 수정 했습니다.")
                    .result(request)
                    .build();

            return baseRes;

        }
        return null;
    }


    public BaseRes deleteReview(Integer reviewIdx) {
        reviewRepository.delete(Review.builder().reviewIdx(reviewIdx).build());

        BaseRes baseRes = BaseRes.builder()
                .code(200)
                .isSuccess(true)
                .message("리뷰를 삭제했습니다.")
                .result(reviewIdx)
                .build();

        return baseRes;
    }
}
