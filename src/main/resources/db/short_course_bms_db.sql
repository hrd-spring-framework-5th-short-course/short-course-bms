PGDMP     '                     w            short_course_bms_db    11.2    11.2 <    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    16426    short_course_bms_db    DATABASE     �   CREATE DATABASE short_course_bms_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
 #   DROP DATABASE short_course_bms_db;
             postgres    false            �            1255    16872 H   get_book_filter_pagination(integer, character varying, integer, integer)    FUNCTION     �  CREATE FUNCTION public.get_book_filter_pagination(cate_id_param integer, book_title_param character varying, limit_param integer, offset_param integer) RETURNS TABLE(book_id integer, book_title character varying, book_author character varying, book_publiser character varying, book_thumbnail character varying, category_id integer, category_name character varying)
    LANGUAGE plpgsql
    AS $$
DECLARE
  --   your variable;
BEGIN
  if cate_id_param isnull
  then
    raise notice 'meme';
    return query select b.id     as book_id,
                        b.title  as book_title,
                        b.author as book_author,
                        b.publisher book_publiser,
                        b.thumbnail book_thumbnail,
                        c.id        category_id,
                        c.name      category_name
                 from tb_book b
                        inner join tb_category c on b.cate_id = c.id
                 where b.title ilike '%' || book_title_param || '%'
                 limit limit_param
                 offset offset_param;
  else
    return query select b.id, b.title, b.author, b.publisher, b.thumbnail, c.id, c.name
                 from tb_book b
                        inner join tb_category c on b.cate_id = c.id
                 where b.cate_id = cate_id_param
                   and b.title ilike '%' || book_title_param || '%'
                 limit limit_param
                 offset offset_param;
  end if;
END;
$$;
 �   DROP FUNCTION public.get_book_filter_pagination(cate_id_param integer, book_title_param character varying, limit_param integer, offset_param integer);
       public       postgres    false            �            1259    16978 	   tb_author    TABLE     �   CREATE TABLE public.tb_author (
    id integer NOT NULL,
    name character varying,
    contact character varying(20),
    status boolean DEFAULT true,
    created_at timestamp without time zone DEFAULT now()
);
    DROP TABLE public.tb_author;
       public         postgres    false            �            1259    16976    tb_author_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.tb_author_id_seq;
       public       postgres    false    197            �           0    0    tb_author_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.tb_author_id_seq OWNED BY public.tb_author.id;
            public       postgres    false    196            �            1259    17004    tb_book    TABLE       CREATE TABLE public.tb_book (
    id integer NOT NULL,
    title character varying,
    isbn character varying,
    book_image character varying,
    cate_id integer,
    publish_date date,
    status boolean DEFAULT true,
    created_at timestamp without time zone DEFAULT now()
);
    DROP TABLE public.tb_book;
       public         postgres    false            �            1259    17022    tb_book_author    TABLE     l   CREATE TABLE public.tb_book_author (
    id integer NOT NULL,
    book_id integer,
    author_id integer
);
 "   DROP TABLE public.tb_book_author;
       public         postgres    false            �            1259    17020    tb_book_author_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_book_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tb_book_author_id_seq;
       public       postgres    false    203            �           0    0    tb_book_author_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.tb_book_author_id_seq OWNED BY public.tb_book_author.id;
            public       postgres    false    202            �            1259    17002    tb_book_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.tb_book_id_seq;
       public       postgres    false    201            �           0    0    tb_book_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.tb_book_id_seq OWNED BY public.tb_book.id;
            public       postgres    false    200            �            1259    16991    tb_category    TABLE     �   CREATE TABLE public.tb_category (
    id integer NOT NULL,
    name character varying,
    status boolean DEFAULT true,
    created_at timestamp without time zone DEFAULT now()
);
    DROP TABLE public.tb_category;
       public         postgres    false            �            1259    16989    tb_category_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.tb_category_id_seq;
       public       postgres    false    199            �           0    0    tb_category_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.tb_category_id_seq OWNED BY public.tb_category.id;
            public       postgres    false    198            �            1259    17070    tb_category_local    TABLE     _   CREATE TABLE public.tb_category_local (
    id integer NOT NULL,
    name character varying
);
 %   DROP TABLE public.tb_category_local;
       public         postgres    false            �            1259    17068    tb_category_local_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_category_local_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.tb_category_local_id_seq;
       public       postgres    false    210            �           0    0    tb_category_local_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.tb_category_local_id_seq OWNED BY public.tb_category_local.id;
            public       postgres    false    209            �            1259    17038    tb_role    TABLE     U   CREATE TABLE public.tb_role (
    id integer NOT NULL,
    name character varying
);
    DROP TABLE public.tb_role;
       public         postgres    false            �            1259    17036    tb_role_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.tb_role_id_seq;
       public       postgres    false    205            �           0    0    tb_role_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.tb_role_id_seq OWNED BY public.tb_role.id;
            public       postgres    false    204            �            1259    17049    tb_user    TABLE     /  CREATE TABLE public.tb_user (
    id integer NOT NULL,
    username character varying,
    fullname character varying,
    gender character varying,
    email character varying,
    status boolean DEFAULT true,
    created_at timestamp without time zone DEFAULT now(),
    password character varying
);
    DROP TABLE public.tb_user;
       public         postgres    false            �            1259    17047    tb_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.tb_user_id_seq;
       public       postgres    false    207            �           0    0    tb_user_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.tb_user_id_seq OWNED BY public.tb_user.id;
            public       postgres    false    206            �            1259    17062    tb_user_role    TABLE     a   CREATE TABLE public.tb_user_role (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);
     DROP TABLE public.tb_user_role;
       public         postgres    false                       2604    16981    tb_author id    DEFAULT     l   ALTER TABLE ONLY public.tb_author ALTER COLUMN id SET DEFAULT nextval('public.tb_author_id_seq'::regclass);
 ;   ALTER TABLE public.tb_author ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    196    197    197                       2604    17007 
   tb_book id    DEFAULT     h   ALTER TABLE ONLY public.tb_book ALTER COLUMN id SET DEFAULT nextval('public.tb_book_id_seq'::regclass);
 9   ALTER TABLE public.tb_book ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    201    200    201                       2604    17025    tb_book_author id    DEFAULT     v   ALTER TABLE ONLY public.tb_book_author ALTER COLUMN id SET DEFAULT nextval('public.tb_book_author_id_seq'::regclass);
 @   ALTER TABLE public.tb_book_author ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    202    203    203                       2604    16994    tb_category id    DEFAULT     p   ALTER TABLE ONLY public.tb_category ALTER COLUMN id SET DEFAULT nextval('public.tb_category_id_seq'::regclass);
 =   ALTER TABLE public.tb_category ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    198    199                       2604    17073    tb_category_local id    DEFAULT     |   ALTER TABLE ONLY public.tb_category_local ALTER COLUMN id SET DEFAULT nextval('public.tb_category_local_id_seq'::regclass);
 C   ALTER TABLE public.tb_category_local ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    209    210    210                       2604    17041 
   tb_role id    DEFAULT     h   ALTER TABLE ONLY public.tb_role ALTER COLUMN id SET DEFAULT nextval('public.tb_role_id_seq'::regclass);
 9   ALTER TABLE public.tb_role ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    205    204    205                       2604    17052 
   tb_user id    DEFAULT     h   ALTER TABLE ONLY public.tb_user ALTER COLUMN id SET DEFAULT nextval('public.tb_user_id_seq'::regclass);
 9   ALTER TABLE public.tb_user ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    206    207    207            �          0    16978 	   tb_author 
   TABLE DATA               J   COPY public.tb_author (id, name, contact, status, created_at) FROM stdin;
    public       postgres    false    197   :G       �          0    17004    tb_book 
   TABLE DATA               i   COPY public.tb_book (id, title, isbn, book_image, cate_id, publish_date, status, created_at) FROM stdin;
    public       postgres    false    201   �G       �          0    17022    tb_book_author 
   TABLE DATA               @   COPY public.tb_book_author (id, book_id, author_id) FROM stdin;
    public       postgres    false    203   }H       �          0    16991    tb_category 
   TABLE DATA               C   COPY public.tb_category (id, name, status, created_at) FROM stdin;
    public       postgres    false    199   �H       �          0    17070    tb_category_local 
   TABLE DATA               5   COPY public.tb_category_local (id, name) FROM stdin;
    public       postgres    false    210   9I       �          0    17038    tb_role 
   TABLE DATA               +   COPY public.tb_role (id, name) FROM stdin;
    public       postgres    false    205   fI       �          0    17049    tb_user 
   TABLE DATA               f   COPY public.tb_user (id, username, fullname, gender, email, status, created_at, password) FROM stdin;
    public       postgres    false    207   �I       �          0    17062    tb_user_role 
   TABLE DATA               8   COPY public.tb_user_role (user_id, role_id) FROM stdin;
    public       postgres    false    208   XJ       �           0    0    tb_author_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tb_author_id_seq', 2, true);
            public       postgres    false    196            �           0    0    tb_book_author_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.tb_book_author_id_seq', 6, true);
            public       postgres    false    202            �           0    0    tb_book_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.tb_book_id_seq', 4, true);
            public       postgres    false    200            �           0    0    tb_category_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tb_category_id_seq', 10, true);
            public       postgres    false    198            �           0    0    tb_category_local_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.tb_category_local_id_seq', 1, true);
            public       postgres    false    209            �           0    0    tb_role_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.tb_role_id_seq', 4, true);
            public       postgres    false    204            �           0    0    tb_user_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.tb_user_id_seq', 3, true);
            public       postgres    false    206                       2606    16988    tb_author tb_author_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.tb_author
    ADD CONSTRAINT tb_author_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.tb_author DROP CONSTRAINT tb_author_pkey;
       public         postgres    false    197                        2606    17014    tb_book tb_book_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tb_book
    ADD CONSTRAINT tb_book_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tb_book DROP CONSTRAINT tb_book_pkey;
       public         postgres    false    201            *           2606    17078 (   tb_category_local tb_category_local_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.tb_category_local
    ADD CONSTRAINT tb_category_local_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.tb_category_local DROP CONSTRAINT tb_category_local_pkey;
       public         postgres    false    210                       2606    17001    tb_category tb_category_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_category
    ADD CONSTRAINT tb_category_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.tb_category DROP CONSTRAINT tb_category_pkey;
       public         postgres    false    199            "           2606    17046    tb_role tb_role_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tb_role
    ADD CONSTRAINT tb_role_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tb_role DROP CONSTRAINT tb_role_pkey;
       public         postgres    false    205            $           2606    17059    tb_user tb_user_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tb_user DROP CONSTRAINT tb_user_pkey;
       public         postgres    false    207            (           2606    17066    tb_user_role tb_user_role_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tb_user_role
    ADD CONSTRAINT tb_user_role_pkey PRIMARY KEY (user_id, role_id);
 H   ALTER TABLE ONLY public.tb_user_role DROP CONSTRAINT tb_user_role_pkey;
       public         postgres    false    208    208            &           2606    17061    tb_user tb_user_username_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_username_key UNIQUE (username);
 F   ALTER TABLE ONLY public.tb_user DROP CONSTRAINT tb_user_username_key;
       public         postgres    false    207            -           2606    17031 ,   tb_book_author tb_book_author_author_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_book_author
    ADD CONSTRAINT tb_book_author_author_id_fkey FOREIGN KEY (author_id) REFERENCES public.tb_author(id);
 V   ALTER TABLE ONLY public.tb_book_author DROP CONSTRAINT tb_book_author_author_id_fkey;
       public       postgres    false    197    3100    203            ,           2606    17026 *   tb_book_author tb_book_author_book_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_book_author
    ADD CONSTRAINT tb_book_author_book_id_fkey FOREIGN KEY (book_id) REFERENCES public.tb_book(id);
 T   ALTER TABLE ONLY public.tb_book_author DROP CONSTRAINT tb_book_author_book_id_fkey;
       public       postgres    false    203    3104    201            +           2606    17015    tb_book tb_book_cate_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_book
    ADD CONSTRAINT tb_book_cate_id_fkey FOREIGN KEY (cate_id) REFERENCES public.tb_category(id);
 F   ALTER TABLE ONLY public.tb_book DROP CONSTRAINT tb_book_cate_id_fkey;
       public       postgres    false    201    199    3102            �   H   x�3��K��404036�4317�,�420��5��54R04�20�21�31��05�2��M�M��71#�>F��� ��      �   �   x�}�=N�0��>E.`����@�=�6�� ��M��	[�BA�i���}��c8�}���$Ģd*F�NO&��r t��1 �	G��
,���۰.��2����Y�dr2�j��h�CT8 �'w�ϳ#�}��ڲTIJ1�Te��ta$�-Q|�����iI"�fc�˷�'�j6I�.�
�5q�Z��ć�ݍ��p��s4�
�O�{�	^�N/      �   *   x�3�4�4�2�F\Ɯ@�˄�H�I#.3N ���� fs�      �   r   x�3�t���t�,�420��5��54R04�20�2�г46422�2�ru�įʘ�-1�$���2N�����"��8��sS�KR����42�20�26�3��02������� }*,      �      x�3���MUpN,IM�/������ FX�      �   (   x�3�t��2�tqr�2�tt����2�v����� e�      �   �   x�����0F��S0�R�
L"*jԨ,.W��H!���E_��KN���0h�@�uS�#�r�e>���FU�g��NYh��f�d,�~�<�{!�X-F��i;'��]�E\;�C%S���S�>��<�������w��Y������6��D�Ԁ������M~'�a|k�      �      x�3�4�2�4bm����� i�     