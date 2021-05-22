package com.nh7.ecommerce.service;

import com.nh7.ecommerce.dto.PostDto;
import com.nh7.ecommerce.dto.ShopDto;
import com.nh7.ecommerce.entity.Post;
import com.nh7.ecommerce.entity.Shop;
import com.nh7.ecommerce.entity.User;
import com.nh7.ecommerce.repository.PostRepository;
import com.nh7.ecommerce.repository.UserRepository;
import com.nh7.ecommerce.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    Post getPostById(int id) {return postRepository.findById(id);}
    List<Post> getAllPost(){return (List<Post>) postRepository.findAll();}
    // CODE BY HUY
    void create(Post post){postRepository.save(post);}
    //
    @Autowired
    private ModelMapperUtil modelMapperUtil;
    public List<PostDto> findAll(){
        List<Post> posts= (List<Post>) postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for(Post post : posts){
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setPostTitle(post.getPostTitle());
            postDto.setPostDescription(post.getPostDescription());
            postDtos.add(postDto);
        }
        return postDtos;
    }
    public PostDto findById(long id){
        Post post = postRepository.findById(id);
        return modelMapperUtil.map(post,PostDto.class);
    }

    public List<Post> saveAll(List<Post> posts){
        return (List<Post>) postRepository.saveAll(posts);
    }

    public void save(Post post){
        Post savePost = postRepository.save(post);
        Long id = userRepository.findIdByUsername(post.getCreatedBy());
        User user = userRepository.findById(id).get();
        savePost.setUser(user);
        postRepository.save(savePost);
    }

    public void deleteAll(){
        postRepository.deleteAll();
    }

    public void delete(Long id){
        postRepository.deleteById(id);
    }
}
