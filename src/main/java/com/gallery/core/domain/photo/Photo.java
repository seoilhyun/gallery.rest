package com.gallery.core.domain.photo;

import com.gallery.core.domain.support.file.ImageFile;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 5.
 * Time: 오후 6:06
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
public class Photo {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String caption;

    @OneToOne(cascade = CascadeType.ALL)
    private ImageFile image;

    public Photo(String caption, MultipartFile image) {
        setCaption(caption);
        setImage(new ImageFile(image));
    }
}
