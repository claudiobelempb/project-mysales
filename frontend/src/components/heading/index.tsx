interface HeadingProps {
  title: string;
  subTitle: string;
  children?: React.ReactNode;
}

export const Heading: React.FC<HeadingProps> = ({
  title,
  subTitle
}: HeadingProps) => {
  return (
    <div>
      <h1 className='font-black text-3 text-gray-900'>{title}</h1>
      <h2 className='font-light text-sm text-gray-600'>{subTitle}</h2>
    </div>
  );
};
