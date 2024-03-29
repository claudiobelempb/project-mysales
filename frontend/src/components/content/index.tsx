interface Contentrops {
  children?: React.ReactNode;
}

export const Content: React.FC<Contentrops> = ({ children }: Contentrops) => {
  return <div className='flex flex-col'>{children}</div>;
};
