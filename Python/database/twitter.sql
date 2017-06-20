 -- TWITTER
 -- 1. What query would you run to get all tweets from the user id of 1?

use twitter;

 select tweet from tweets
 where user_id = 1;


select * from users
left join tweets
on users.id = tweets.user_id
where user_id = 1;

select tweets.tweet
from users 
left join tweets
on users.id = tweets.user_id
where users.id=1;

-- 2. What query would return all the tweets that the user with id 2 has tagged as favorites?


select * from users;

select * from faves;

select first_name, tweet
from users
left join faves
on users.id = faves.user_id
left join tweets
on tweets.id = faves.tweet_id
where users.id = 2;

-- 3. What query would you run to get all the tweets that user with id 2, or user with id 1, has tagged as favorites?
select first_name, tweet
from users
left join faves
on users.id = faves.user_id
left join tweets
on tweets.id = faves.tweet_id
where users.id = 2 or users.id = 3;

-- 4. What query would you run to get all the users that are following the user with id 1?
select users.first_name as followed, users2.first_name as follower
from users
left join follows
on users.id = follows.followed_id
left join users as users2
on users2.id = follows.follower_id
where users.id = 1;

-- select * from follows;

