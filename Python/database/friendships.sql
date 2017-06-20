SELECT users.first_name as first_name,  users.last_name as last_name, user2.first_name as friend_first_name,  user2.last_name as friend_last_name FROM users 
LEFT JOIN friendships ON users.id = friendships.user_id
LEFT JOIN users as user2 ON user2.id =friendships.friend_id
-- 



-- Insert into friendships (created_at, updated_at, user_id, friend_id)
-- values (now(), now(), 11, 12);
-- Insert into friendships (created_at, updated_at, user_id, friend_id)
-- values (now(), now(), 11, 13);
-- Insert into friendships (created_at, updated_at, user_id, friend_id)
-- values (now(), now(), 11, 14);
-- Insert into friendships (created_at, updated_at, user_id, friend_id)
-- values (now(), now(), 14, 11);
-- Insert into friendships (created_at, updated_at, user_id, friend_id)
-- values (now(), now(), 13, 11);
-- Insert into friendships (created_at, updated_at, user_id, friend_id)
-- values (now(), now(), 12, 11);
-- 
-- SELECT * FROM friendships;